package com.mrpicker.chapter2;/**
 * Created by 姜腾 on 2020/6/14.
 */

import com.mrpicker.base.BaseRule;

import java.io.*;

/**
 * @program: effectiveJava
 * @description: try-with-resources优于try-finally
 * @author: Mrpicker
 * @create: 2020-06-14 20:52
 **/
public class Rule9 extends BaseRule {
    public Rule9() {
        super("try-with-resources优于try-finally");
        addKeyPoint("try-finally在同时处理两条或多条ioStream时会显得非常差劲,可能会覆盖异常");
        addKeyPoint("遇到io处理时，try-with-resources使用起来十分简洁易懂，也更容易诊断问题");
    }
}

//try-finally
class example9_1 {
    String firstLineOfFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    void copy(String src, String dst) throws IOException {
        InputStream inputStream = new FileInputStream(src);
        try {
            OutputStream outputStream = new FileOutputStream(dst);
            try {
                byte[] buffer = new byte[1024];
                int n;
                while ((n = inputStream.read(buffer)) >= 0) {
                    outputStream.write(buffer, 0, n);
                }
            } finally {
                outputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}

//try-with-resources
class example9_2 {
    String firstLineOfFile(String path, String defaultStr) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return defaultStr;
        }
    }

    void copy(String src, String dst) throws IOException {
        try (InputStream inputStream = new FileInputStream(src);
             OutputStream outputStream = new FileOutputStream(dst)) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, n);
            }
        }
    }
}
