/*
 * Copyright (c) 2008, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the Classpath exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package samples;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.BTraceUtils.Reflective;
import com.sun.btrace.BTraceUtils.Threads;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;

/**
 * A simple BTrace program that prints stack trace whenever a class is loaded by
 * a user-defined class loader. We insert a return point probe in
 * ClassLoader.defineClass method to detect successful class load.
 */
@BTrace
public class Classload {
    @OnMethod(clazz = "+java.lang.ClassLoader", method = "defineClass", location = @Location(Kind.RETURN))
    public static void defineclass(@Return Class cl) {
        println("loaded " + Reflective.name(cl));
        Threads.jstack();
        println("==========================");
    }
}
