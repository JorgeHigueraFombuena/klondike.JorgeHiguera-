package miw.upm.es.klondike.controller.local;

import java.util.ArrayList;
import java.util.List;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveCardControllerVisitor;
import miw.upm.es.klondike.controller.MoveFromDiscardToStrightController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public class LocalMoveFromDiscardToStrightController extends LocalPlaceCardController
		implements MoveFromDiscardToStrightController {

	public LocalMoveFromDiscardToStrightController(Game game) {
		super(game);
	}

	@Override
	public void accept(MoveCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public Error move(int targetStright) {
		List<Card> placedCards = super.getFaceUpCardsOfStright(targetStright);
		Card toPlace = super.getFirstCardFromDiscard();
		List<Card> cardFromDiscard = new ArrayList<Card>();
		if (toPlace != null) {
			cardFromDiscard.add(toPlace);
		}
		if (placedCards == null) {
			placedCards = new ArrayList<Card>();
		}
		Error error = super.movedPermited(cardFromDiscard, placedCards, PlaceOfCard.STRIGHT);
		if (error == null) {
			super.move(toPlace, targetStright);
		}
		return error;
	}

}
