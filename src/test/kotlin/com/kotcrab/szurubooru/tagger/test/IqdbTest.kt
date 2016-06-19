package com.kotcrab.szurubooru.tagger.test

import com.kotcrab.szurubooru.tagger.IqdbServices
import com.kotcrab.szurubooru.tagger.queryIqdb
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.io.File
import java.util.*

/**
 * Test Iqdb integration by sending test query. This test has to assume that url of image under test will never change.
 * @author Kotcrab
 */
class IqdbTest {
    @Test
    fun testMatchingIqdbQuery() {
        val file = IqdbTest::class.java.getResource("/caster.jpg").file
        val url = queryIqdb(File(file), EnumSet.of(IqdbServices.Danbooru))
        assertEquals("https://danbooru.donmai.us/posts/1384292", url)
    }

    @Test
    fun testNotMatchingIqdbQuery() {
        val file = IqdbTest::class.java.getResource("/random.png").file
        val url = queryIqdb(File(file), EnumSet.of(IqdbServices.Danbooru))
        assertNull(url)
    }
}
