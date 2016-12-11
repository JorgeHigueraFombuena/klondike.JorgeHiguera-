package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.model.Game;

public class LocalMoveFromDeckToDiscardController extends LocalMoveCardContoller
		implements MoveFromDeckToDiscardController {
	
	public LocalMoveFromDeckToDiscardController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public Error move() {
		super.moveFromDeckToDiscard();
		return null;
	}


}