package bridge.view;


import bridge.message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeLen(){
        String input = "";
        while(true){
            outputView.printRequestSize();
            try{
                input = Console.readLine();
                validateInputNumber(input);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = "";
        while(true){
            outputView.printRequestUpDownMessage();
            try{
                input = Console.readLine();
                validateMoveInput(input);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = "";
        while(true){
            outputView.printRequestRetry();
            try{
                input = Console.readLine();
                validateReStartInput(input);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private static void validateInputNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
            }
        }
        int len = Integer.parseInt(input);
        if(len < 3 || len > 20){
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_RETRY_INPUT_ERROR.getMessage());
        }
    }

    private static void validateMoveInput(String input){
        if(!(input.equals("U") || input.equals("D"))){
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_MOVE_INPUT_ERROR.getMessage());
        }
    }

    private static void validateReStartInput(String input){
        if(!(input.equals("R") || input.equals("Q"))){
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_RETRY_INPUT_ERROR.getMessage());
        }
    }

}
