package com.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// TBDeleted
public class Ex1 {

    public static void main(String[] args) {
        String working = "\"$JAVA\" $JVM_OPTVERSION -verbose:gc -Xloggc:\"$JBOSS_LOG_DIR/gc.log\" -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=3M -XX:-TraceClassUnloading -version >/dev/null 2>&1 && mkdir -p $JBOSS_LOG_DIR && PREPEND_JAVA_OPTS=\"$PREPEND_JAVA_OPTS -verbose:gc -Xloggc:\\\"$JBOSS_LOG_DIR/gc.log\\\" -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=3M -XX:-TraceClassUnloading\"";
        String vob = "\"$JAVA\" $JVM_OPTVERSION -verbose:gc -XX:-TraceClassUnloading -version >/dev/null 2>&1 && mkdir -p $JBOSS_LOG_DIR && PREPEND_JAVA_OPTS=\"$PREPEND_JAVA_OPTS -verbose:gc -Xloggc:\\\"$JBOSS_LOG_DIR/gc.log\\\" -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=3M -XX:-TraceClassUnloading\"";

        String[] working_arr = working.split(String.valueOf(' '));
        String[] vob_arr = vob.split(String.valueOf(' '));

        Arrays.sort(working_arr);
        Arrays.sort(vob_arr);
        System.out.println(Arrays.toString(working_arr));
        System.out.println(Arrays.toString(vob_arr));
        System.out.println(List.of(vob_arr));

        System.out.println(working_arr.length + " " + vob_arr.length);

        HashSet<String> wset = new HashSet<>(List.of(working_arr));
        HashSet<String> vset = new HashSet<>(List.of(vob_arr));
        HashSet<String> common = new HashSet<>();
        HashSet<String> wsetonly = new HashSet<>();
        HashSet<String> vsetonly = new HashSet<>();

        for (String elem :
                wset) {
            if(vset.contains(elem)){
                common.add(elem);
            }else{
                wsetonly.add(elem);
            }

        }
        System.out.println(common);
        System.out.println(wsetonly);
        for (String elem :
                vset) {
            if (!wset.contains(elem)){
                vsetonly.add(elem);
            }
        }
        System.out.println(vsetonly);
    }
}
