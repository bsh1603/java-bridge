package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame(){
        outputView.gameStart();
    }

    public List<String> bridgeMake(){
        int bridgeSize = inputView.readBridgeLen();
        return bridgeGame.makeBridge(bridgeSize);
    }

    public void playBridgeGame(List<String> bridge){
        while(bridgeGame.getSize() < bridge.size()){
            String move = inputView.readMoving();
            String oneBridge = bridgeGame.move(bridge, move, bridgeGame.getSize());
            outputView.printMap(oneBridge);
            bridgeGame.nextStep();

            if(isWrong(oneBridge)){
                bridgeGame.retry();
            }
        }
        outputView.printResult(bridge, bridgeGame);
    }

    public boolean isWrong(String bridge){
        if(bridge.contains("X")){
            return true;
        }
        return false;
    }

}
