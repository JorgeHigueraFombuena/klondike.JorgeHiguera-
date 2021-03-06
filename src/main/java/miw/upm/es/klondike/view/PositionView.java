package miw.upm.es.klondike.view;

import miw.upm.es.klondike.model.Suit;
import miw.upm.es.klondike.utils.IO;
import miw.upm.es.klondike.utils.LimitedIntDialog;
import miw.upm.es.klondike.utils.LimitedSuitDialog;

public class PositionView {

	private String title;

	private String limitDialogTitle;

	private int maxLimit;

	private int position;

	private Suit suit;

	private IO io;

	PositionView(String title, String limitDialogTitle, int maxLimit) {
		assert title != null;
		assert limitDialogTitle != null;
		assert maxLimit > 0;
		this.title = title;
		this.limitDialogTitle = limitDialogTitle;
		this.maxLimit = maxLimit;
		io = new IO();
	}

	PositionView(String title, String limitDialogTitle) {
		assert title != null;
		assert limitDialogTitle != null;
		this.title = title;
		this.limitDialogTitle = limitDialogTitle;
		io = new IO();
	}

	int getPosition() {
		return position;
	}

	Suit getSuit() {
		return suit;
	}

	void readInt() {
		io.writeln(title);
		position = new LimitedIntDialog(limitDialogTitle, maxLimit).read();
	}

	void readSuit() {
		io.writeln(title);
		suit = new LimitedSuitDialog().read();
	}

}
