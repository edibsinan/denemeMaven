package com.techproed;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotation {

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Before
    public void test2() {
        System.out.println("Test 2");
    }

    @Ignore
    @Test
    public void test3() {
        System.out.println("Test 3 ");
    }
}

