package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int manualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<List<Integer>> manualLottoNumbers(int count) {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            manualLottoNumbers.add(inputLottoNumbers());
        }
        return manualLottoNumbers;
    }

    public static List<Integer> winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumbers();
    }

    public static Integer bonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static List<Integer> inputLottoNumbers() {
        String[] inputLottoNumbers = SCANNER.nextLine().split(", ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (String inputLottoNumber : inputLottoNumbers) {
            nums.add(Integer.parseInt(inputLottoNumber));
        }
        return nums;
    }
}
