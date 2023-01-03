package com.pages.service;
import com.pages.model.*;

public class PhraseService {
	public void addVariation(Page page, int paragraphIndex, String phraseText, String variation, boolean primary) {
		Paragraph paragraph = page.getParagraph(paragraphIndex);
		Phrase phrase = paragraph.getPhrase(phraseText);
		if (phrase == null) {
			phrase = new Phrase(phraseText, primary);
			paragraph.addPhrase(phrase);
		} else if (primary) {
			phrase.setPrimary(true);
		}
		phrase.addVariation(variation);
	}
}