package dev.tvnclr.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import org.junit.Assert.assertTrue
import org.junit.Test

/** Text on an accent fill (primary button, selected segment and chip, switch thumb) must stay readable. */
class OnColorTest {
  private val onDark = Color(0xFF15131C)

  private fun contrast(a: Color, b: Color): Float {
    val la = a.luminance() + 0.05f
    val lb = b.luminance() + 0.05f
    return maxOf(la, lb) / minOf(la, lb)
  }

  private fun tones() = TvAccent.values().flatMap { listOf(it.name + " dark" to it.dark, it.name + " light" to it.light) }

  @Test
  fun everyAccentToneReadsAtAA() {
    for ((name, tone) in tones()) {
      val ratio = contrast(onColorFor(tone), tone)
      assertTrue("$name: text on accent is $ratio:1, needs 4.5:1", ratio >= 4.5f)
    }
  }

  @Test
  fun picksTheHigherContrast() {
    for ((name, tone) in tones()) {
      val on = onColorFor(tone)
      val other = if (on == Color.White) onDark else Color.White
      assertTrue("$name: the other on-color reads better", contrast(on, tone) >= contrast(other, tone))
    }
  }
}