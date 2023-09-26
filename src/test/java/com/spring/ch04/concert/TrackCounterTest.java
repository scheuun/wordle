package com.spring.ch04.concert;

import com.spring.ch02.xmlconfig.CompactDisc;
import com.spring.ch04.soundsystem.TrackCounter;
import com.spring.ch04.soundsystem.TrackCounterConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Rule
    public final StandardOutputStreamLog log =
            new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);

        assertEquals(1, counter.getPlayCount(1));
        assertEquals(1, counter.getPlayCount(2));
        assertEquals(1, counter.getPlayCount(3));
        assertEquals(1, counter.getPlayCount(4));
        assertEquals(1, counter.getPlayCount(5));
        assertEquals(1, counter.getPlayCount(6));
        assertEquals(1, counter.getPlayCount(7));
    }

}
