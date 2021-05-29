package com.cos.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.cos.annot.Name;
import com.cos.annot.Z;

public class Main_Program {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		final Method method = Z.class.getMethod("something");
		if (method.isAnnotationPresent(Name.class)) {
			final Annotation annotation = method.getAnnotation(Name.class);
			final Name name = (Name)annotation;
			System.out.println(name.myName());
		}
	}
}
