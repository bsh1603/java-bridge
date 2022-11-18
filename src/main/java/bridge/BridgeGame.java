package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();

    public void gameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public int requestBridgeSize(){
        System.out.println("다리 길이를 입력해주세요.");
        while(true){
            try{
                inputView.readBridgeSize();
                return inputView.readBridgeSize();
            }catch (IllegalArgumentException e){
                System.out.println("다리 길이를 입력해주세요");
                inputView.readBridgeSize();
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
