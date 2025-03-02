package com.xiaomaweii.example.publish;

import com.xiaomaweii.annoations.NotRecommend;
import com.xiaomaweii.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoweii
 * @create 2025-03-02 18:28
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
