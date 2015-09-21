package com.mehmetakiftutuncu.muezzinapi.utilities

import java.util.Locale

/**
 * A utility object for utility stuff (utilitiception)
 */
object Utils {
  /**
   * Sanitizes and beautifies a string
   *
   * @param str               String to sanitize
   * @param replaceHtmlChars  If true, HTML entity encoded characters will be replaced by their actual values
   * @param upperCaseEachWord If true, each word will start with uppercase letter
   * @param locale            Case conversions will be done using this [[java.util.Locale]]
   *
   * @return Sanitized string
   */
  def sanitizeHtml(str: String,
                   replaceHtmlChars: Boolean = true,
                   upperCaseEachWord: Boolean = true,
                   locale: Locale = Locale.getDefault): String = {
    val uppercasedResult = {
      if (upperCaseEachWord) {
        str.toLowerCase(locale)
           .split(" ")
           .map(w => w.take(1).toUpperCase(locale) + w.drop(1))
           .mkString(" ")
      } else {
        str
      }
    }

    val replacedResult = if (replaceHtmlChars) {
      uppercasedResult.replaceAll("&#304;", "İ")
            .replaceAll("&#214;", "Ö")
            .replaceAll("&#220;", "Ü")
            .replaceAll("&#199;", "Ç")
            .replaceAll("&#286;", "Ğ")
            .replaceAll("&#350;", "Ş")
            .replaceAll("&#305;", "ı")
            .replaceAll("&#246;", "ö")
            .replaceAll("&#252;", "ü")
            .replaceAll("&#231;", "ç")
            .replaceAll("&#287;", "ğ")
            .replaceAll("&#351;", "ş")
    } else {
      uppercasedResult
    }

    replacedResult.replaceAll("[^\\pL\\s]", "").trim
  }
}
