package org.cloud.mud.test;

import org.cloud.mud.playbook.Playbook;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PlaybookTest {
    Pattern askPattern = Pattern.compile("(ask)\\s(\\D+\\s)+\\[(\\D+)\\]");
    Pattern textPattern = Pattern.compile("^(text)\\s(\\D+)$");
    Pattern battlePattern = Pattern.compile("^(battle)\\s(.*)$");

    @Before
    public void setUp() {

    }

    @Test
    public void test_ask_pattern_ok() {
        Matcher matcher = askPattern.matcher("ask would you help me? [help,do not help,leave]");
        assertThat(matcher.matches(), is(true));
        assertThat(matcher.group(1), is("ask"));
        assertThat(matcher.group(2), is("would you help me? "));
        assertThat(matcher.group(3), is("help,do not help,leave"));
    }

    @Test
    public void test_text_pattern() {
        Matcher matcher = textPattern.matcher("text hello my friend");
        assertThat(matcher.matches(), is(true));
        assertThat(matcher.group(1), is("text"));
        assertThat(matcher.group(2), is("hello my friend"));
    }

    @Test
    public void test_battle_pattern() {

    }

    public int getLevel(String line) {
        return line.split("\t").length - 1;
    }

    class Node {
        private String context;
        private Node prev;
        private Node next;
        public Node() {

        }
    }

    @Test
    public void test_play_book() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/playbook.text"));
        Playbook playbook = new Playbook();
        String line;
        String prev=null;
        String root = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split("\t");
            if(prev == null && getLevel(line) == 0) {
                root = prev = line;
            }
            // equal prev level
        }

    }
}
