package com.mrpicker.chapter2;

import com.mrpicker.base.BaseRule;

import java.util.HashMap;

/**
 * @program: effectiveJava
 * @description: 优先考虑依赖注入来引入资源
 * @author: Mrpicker
 * @create: 2020-06-10 16:36
 **/
public class Rule5 extends BaseRule {
    public Rule5() {
        super("优先考虑依赖注入来引入资源");
        addKeyPoint("静态工具类和Singleton类不适合于需要引用底层资源的类");
        addKeyPoint("依赖注入最简单的一个模式是：当创建一个新的实例时，就将该资源传到构造器中");//example5_1
        addKeyPoint("依赖注入的对象资源具有不可变性（See Rule17）");
        addKeyPoint("依赖注入的一个变体是：可以将资源工厂传给构造器。例如一个Supplier");
        addBenefit("提升了灵活性和测试性。将资源创建和资源使用解耦");
        addWeakPoint("在大型系统中可能会很复杂，这个可以通过依赖注入框架（ex:Spring,Dagger）来解决。");
        setSummary("不要用Singleton或静态工具的模式来实现一个依赖底层资源的类；也不要在这个类直接创建资源。而应当把\n" +
                "资源或资源工厂从外部传给类的构造器（或者是静态工厂 or Builder），再通过它们来创建该类。将资源的创建和使用进行解耦。\n" +
                "这个实践就叫做依赖注入，它极大提升了类的灵活性，可重用性和可测试性");
    }
}

class Lexicon {
    private static int id = 0;

    String name;

    public Lexicon() {
        id++;
    }

    public String find(String key) {
        return "";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

class example5_1 {


    class DISpellChecker {
        private final Lexicon lexicon;

        //Dependency Injection implemented by constructor
        DISpellChecker(Lexicon lexicon) {
            this.lexicon = lexicon;
        }
    }
}

class example5_2 {
    public static void main(String[] args) {
        DISpellCheck2 sp1 = new DISpellCheck2(ObjectConfigure.LEXICON1);
        DISpellCheck2 sp2 = new DISpellCheck2(ObjectConfigure.LEXICON1);
        new DISpellCheck2("xxxBean");
    }

    /**
     * 配置文件，在这里配置Bean
     */
    static class ObjectConfigure {
        public static final String LEXICON1 = "lexicon1";

        static HashMap<String, Class> idClassMap = new HashMap<String, Class>() {
            {
                put(LEXICON1, Lexicon.class);
            }
        };
    }

    /**
     * Bean工厂，读取配置文件并产生Bean
     */
    static class ObjectFactory {
        private static final ObjectFactory instance = new ObjectFactory();

        final HashMap<String, Class> configure;
        HashMap<String, Object> idObjectMap;


        private ObjectFactory() {
            configure = ObjectConfigure.idClassMap;
            idObjectMap = new HashMap<>();
        }

        public static ObjectFactory getInstance() {
            return instance;
        }

        public Object getBean(String beanId) {
            Object o = idObjectMap.get(beanId);
            if (o != null) {
                return o;
            }
            Class beanClass = configure.get(beanId);
            if (beanClass != null) {
                try {
                    Object o1 = beanClass.newInstance();
                    //Bean工厂可以缓存Bean
                    idObjectMap.put(beanId, o1);
                    return o1;
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException(String.format("beanId:%s is not registered!", beanId));
            }
        }
    }

    static class DISpellCheck2 {
        private final Lexicon lexicon;

        public DISpellCheck2(String lexiconId) {
            //通过Bean工厂注入Bean
            lexicon = (Lexicon) ObjectFactory.getInstance().getBean(lexiconId);
            System.out.println(lexicon);
        }
    }
}




