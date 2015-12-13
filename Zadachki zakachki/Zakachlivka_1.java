import java.util.Scanner;

public class Zakachlivka_1 {

	public static void main(String[] args) {

		char[][] encryptingMatrix = { { 'A', 'B', 'C', 'D', 'E' }, { 'F', 'G', 'H', 'I', 'J' },
				{ 'K', 'L', 'M', 'N', 'O' }, { 'P', 'Q', 'R', 'S', 'T' }, { 'U', 'V', 'W', 'X', 'Y' } };

		String encryptedText = encryptText(encryptingMatrix);
		System.out.println(encryptedText + "\n");
		// String decryptedText =
		// decryptText(encryptingMatrix, encryptedText);-���� ������� �� �
		// ������� ���� ���� ����� ������� ������������.
		System.out.println(decryptText(encryptedText, encryptingMatrix));

	}

	static String encryptText(char[][] encryptingMatrix) {

		// �������� �� ��� �� ������� �� �������� ���� �������� ������� ��������
		// ��
		// ������������ ������: ���� ������ �����, ��� Z, �� �� �� ��������,
		// ��������� �� � 5�5 � �.�. ���� �� ������, ��� �� ��� � ��-����� �� ��
		// ������ keyMatrix :-P
		if (encryptingMatrix.length != 5) {
			System.out.println("Encrypring matrix should be of 5x5 size! ENCRYPTION NOT POSSIBLE!");
			return "";
		}
		for (int i = 0; i < encryptingMatrix.length; i++) {
			if (encryptingMatrix[i].length != 5) {
				System.out.println("Encrypting matrix should be of 5x5 size! ENCRYPTION NOT POSSIBLE!");
				return "";
			}
		}

		for (int i = 0; i < encryptingMatrix.length; i++) {
			for (int j = 0; j < encryptingMatrix.length; j++) {
				if (!((encryptingMatrix[i][j] >= 'A') && (encryptingMatrix[i][j] <= 'Y'))) {
					System.out.println(
							"Encrypting matrix should contain one instance of each of \"A - Y\" symbols! ENCRYPTION NOT POSSIBLE!");
					return "";
				}
				byte countSymbol = 0;
				for (int k = 0; k < encryptingMatrix.length; k++) {
					for (int k2 = 0; k2 < encryptingMatrix.length; k2++) {
						if (encryptingMatrix[i][j] == encryptingMatrix[k][k2]) {
							countSymbol++;
							if (countSymbol > 1) {
								System.out.println(
										"Encrypting matrix should contain JUST ONE instance of each of \"A - Y\" symbols! ENCRYPTION NOT POSSIBLE!");
								return "";
							}
						}
					}
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a text to be encrypted(ONLY LETTERS, excluding \"z\" and \"Z\"!)");
		String textNonEncrypted = sc.nextLine();

		// ���� ���� ��-���� ��������� ���� ������� �� �� �������� �������
		// �������� �� ����� � ������ ��������� �����, ���� "z" � "Z" ���� �� ��
		// ����������. ���� ������ � �� �������.
		// ���������� ���������� ����, ��� ���� � ���������.

		for (int i = 0; i < textNonEncrypted.length(); i++) {
			if (!(((textNonEncrypted.charAt(i) >= 'a') && (textNonEncrypted.charAt(i) < 'z'))
					|| ((textNonEncrypted.charAt(i) >= 'A') && (textNonEncrypted.charAt(i) < 'Z')))) {
				System.out.println(
						"Entered string contains an invalid symbol!!!(Should contain only letters, excluding \"z\" and \"Z\"! ENCRYPTION FAILED!");
				return "";
			}

		}
		String textEncrypted = "";

		// System.out.println("OK");
		if (textNonEncrypted.length() % 2 != 0) {
			textNonEncrypted = textNonEncrypted + "p";
		}
		textNonEncrypted = textNonEncrypted.toUpperCase();
		System.out.println(textNonEncrypted + "\n");

		for (int i = 0; i <= textNonEncrypted.length() - 2; i += 2) {
			byte rowFirstLetter = 0;
			byte colFirstLetter = 0;
			byte rowSecondLetter = 0;
			byte colSecondLetter = 0;
			byte newColFirst = 0;
			byte newColSecond = 0;
			byte newRowFirst = 0;
			byte newRowSecond = 0;
			boolean isSameCol = false;
			boolean isSameRow = false;
			boolean isSameLetter = false;

			for (byte row = 0; row < 5; row++) {
				for (byte col = 0; col < 5; col++) {
					if (encryptingMatrix[row][col] == textNonEncrypted.charAt(i)) {
						rowFirstLetter = row;
						colFirstLetter = col;
						break;
					}

				}
			}
			for (byte row = 0; row < 5; row++) {

				for (byte col = 0; col < 5; col++) {
					if (encryptingMatrix[row][col] == textNonEncrypted.charAt(i + 1)) {
						rowSecondLetter = row;
						colSecondLetter = col;
						break;
					}
				}
			}
			if (textNonEncrypted.charAt(i) == textNonEncrypted.charAt(i + 1)) {
				isSameLetter = true;
			}
			if ((colFirstLetter == colSecondLetter) && (isSameLetter == false)) {

				isSameCol = true;
			}
			if ((rowFirstLetter == rowSecondLetter) && (isSameLetter == false)) {
				isSameRow = true;
				// System.out.println(rowFirstLetter);
				// System.out.println(rowSecondLetter);
			}
			if ((isSameCol == false) && (isSameRow == false) && (isSameLetter == false)) {
				newColFirst = colSecondLetter;
				newColSecond = colFirstLetter;
				newRowFirst = rowFirstLetter;
				newRowSecond = rowSecondLetter;
				// System.out.println(rowFirstLetter);
				// System.out.println(colFirstLetter);
				// System.out.println(rowSecondLetter);
				// System.out.println(colSecondLetter);
			}
			if (isSameCol) {
				newColFirst = colFirstLetter;
				newColSecond = colSecondLetter;
				newRowFirst = (byte) (rowFirstLetter == 4 ? 0 : rowFirstLetter + 1);
				newRowSecond = (byte) (rowSecondLetter == 4 ? 0 : rowSecondLetter + 1);
			}
			if (isSameRow) {
				newColFirst = (byte) (colFirstLetter == 4 ? 0 : colFirstLetter + 1);
				newColSecond = (byte) (colSecondLetter == 4 ? 0 : colSecondLetter + 1);
				newRowFirst = rowFirstLetter;
				newRowSecond = rowSecondLetter;
			}
			if (isSameLetter) {
				// ����� ���, �� ��� �������� ������ ����� �� ������ �� ����
				// � ���� �����, ����. "JJ", �� ����������� ������, � �����
				// ������ �� ��
				// ���� � ���� ���. �� ����� �� �� �������, �� �� � ���� �
				// ���� ������, �� � ��������� �� � �������� ��� ������ ��
				// ����������� ���� ������ ������ �� ���� �� ������� ����.
				// ���� �� � �� �������� ��� ����������� �� ������� ��
				// ������������.
				newColFirst = (byte) (colFirstLetter == 4 ? 0 : colFirstLetter + 1);
				newColSecond = (byte) (colSecondLetter == 4 ? 0 : colSecondLetter + 1);
				newRowFirst = rowFirstLetter;
				newRowSecond = rowSecondLetter;
			}
			// System.out.println(rowFirstLetter);
			// System.out.println(colFirstLetter);
			// System.out.println(rowSecondLetter);
			// System.out.println(colSecondLetter);
			// System.out.println(isSameCol);
			// System.out.println(isSameRow);
			// System.out.println(isSameLetter);
			textEncrypted = textEncrypted + encryptingMatrix[newRowFirst][newColFirst]
					+ encryptingMatrix[newRowSecond][newColSecond];
		}
		for (int i = 0; i < encryptingMatrix.length; i++) {
			for (int j = 0; j < encryptingMatrix.length; j++) {
				System.out.print(encryptingMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		// System.out.println(textEncrypted);

		return textEncrypted;
	}

	static String decryptText(String textEncrypted, char[][] encryptingMatrix) {

		// �������� �� ��� �� ������� �� �������� ���� �������� ������� ��������
		// ��
		// ������������ ������: ���� ������ �����, ��� Z, �� �� �� ��������,
		// ��������� �� � 5�5 � �.�. ���� �� ������, ��� �� ��� � ��-����� �� ��
		// ������ keyMatrix :-P
		if (textEncrypted == "") {
			return "";
		}
		if (encryptingMatrix.length != 5) {
			System.out.println("Encrypring matrix should be of 5x5 size! DECRYPTION NOT POSSIBLE!");
			return "";
		}
		for (int i = 0; i < encryptingMatrix.length; i++) {
			if (encryptingMatrix[i].length != 5) {
				System.out.println("Encrypting matrix should be of 5x5 size! DECRYPTION NOT POSSIBLE!");
				return "";
			}
		}

		for (int i = 0; i < encryptingMatrix.length; i++) {
			for (int j = 0; j < encryptingMatrix.length; j++) {
				if (!((encryptingMatrix[i][j] >= 'A') && (encryptingMatrix[i][j] <= 'Y'))) {
					System.out.println(
							"Encrypting matrix should contain one instance of each of \"A - Y\" symbols! DECRYPTION NOT POSSIBLE!");
					return "";
				}
				byte countSymbol = 0;
				for (int k = 0; k < encryptingMatrix.length; k++) {
					for (int k2 = 0; k2 < encryptingMatrix.length; k2++) {
						if (encryptingMatrix[i][j] == encryptingMatrix[k][k2]) {
							countSymbol++;
							if (countSymbol > 1) {
								System.out.println(
										"Encrypting matrix should contain JUST ONE instance of each of \"A - Y\" symbols! DECRYPTION NOT POSSIBLE!");
								return "";
							}
						}
					}
				}
			}
		}

		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter a text to be encrypted(ONLY LETTERS,
		// excluding \"z\" and \"Z\"!)");
		// String textNonEncrypted = sc.nextLine();

		// ���� ���� ��-���� ��������� ���� ������� �� �� �������� �������
		// �������� �� ����� � ������ ��������� �����, ���� "z" � "Z" ���� �� ��
		// ����������. ���� ������ � �� �������.
		// ���������� ���������� ����, ��� ���� � ���������.

		for (int i = 0; i < textEncrypted.length(); i++) {
			if (!(((textEncrypted.charAt(i) >= 'a') && (textEncrypted.charAt(i) < 'z'))
					|| ((textEncrypted.charAt(i) >= 'A') && (textEncrypted.charAt(i) < 'Z')))) {
				System.out.println(
						"Entered string contains an invalid symbol!!!(Should contain only letters, excluding \"z\" and \"Z\"! ENCRYPTION FAILED!");
				return "";
			}

		}

		if (textEncrypted.length() % 2 != 0) {
			textEncrypted = textEncrypted + "p";
		}
		textEncrypted = textEncrypted.toUpperCase();
		// System.out.println(textEncrypted + "\n");

		String textDecrypted = "";

		for (int i = 0; i <= textEncrypted.length() - 2; i += 2) {
			byte rowFirstLetter = 0;
			byte colFirstLetter = 0;
			byte rowSecondLetter = 0;
			byte colSecondLetter = 0;
			byte newColFirst = 0;
			byte newColSecond = 0;
			byte newRowFirst = 0;
			byte newRowSecond = 0;
			boolean isSameCol = false;
			boolean isSameRow = false;
			boolean isSameLetter = false;

			for (byte row = 0; row < 5; row++) {
				for (byte col = 0; col < 5; col++) {
					if (encryptingMatrix[row][col] == textEncrypted.charAt(i)) {
						rowFirstLetter = row;
						colFirstLetter = col;
						break;
					}

				}
			}
			for (byte row = 0; row < 5; row++) {

				for (byte col = 0; col < 5; col++) {
					if (encryptingMatrix[row][col] == textEncrypted.charAt(i + 1)) {
						rowSecondLetter = row;
						colSecondLetter = col;
						break;
					}
				}
			}
			if (textEncrypted.charAt(i) == textEncrypted.charAt(i + 1)) {
				isSameLetter = true;
			}
			if ((colFirstLetter == colSecondLetter) && (isSameLetter == false)) {

				isSameCol = true;
			}
			if ((rowFirstLetter == rowSecondLetter) && (isSameLetter == false)) {
				isSameRow = true;

			}
			if ((isSameCol == false) && (isSameRow == false) && (isSameLetter == false)) {
				newColFirst = colSecondLetter;
				newColSecond = colFirstLetter;
				newRowFirst = rowFirstLetter;
				newRowSecond = rowSecondLetter;

			}
			if (isSameCol) {
				newColFirst = colFirstLetter;
				newColSecond = colSecondLetter;
				newRowFirst = (byte) (rowFirstLetter == 0 ? 4 : rowFirstLetter - 1);
				newRowSecond = (byte) (rowSecondLetter == 0 ? 4 : rowSecondLetter - 1);
			}
			if (isSameRow) {
				newColFirst = (byte) (colFirstLetter == 0 ? 4 : colFirstLetter - 1);
				newColSecond = (byte) (colSecondLetter == 0 ? 4 : colSecondLetter - 1);
				newRowFirst = rowFirstLetter;
				newRowSecond = rowSecondLetter;
			}
			if (isSameLetter) {
				// ����� ���, �� ��� �������� ������ ����� �� ������ �� ����
				// � ���� �����, ����. "JJ", �� ����������� ������, � �����
				// ������ �� ��
				// ���� � ���� ���. �� ����� �� �� �������, �� �� � ���� �
				// ���� ������, �� � ��������� �� � �������� ��� ������ ��
				// ����������� ���� ������ ������ �� ���� �� ������� ����.
				// ���� �� � �� �������� ��� ����������� �� ������� ��
				// ������������.
				newColFirst = (byte) (colFirstLetter == 0 ? 4 : colFirstLetter - 1);
				newColSecond = (byte) (colSecondLetter == 0 ? 4 : colSecondLetter - 1);
				newRowFirst = rowFirstLetter;
				newRowSecond = rowSecondLetter;
			}

			textDecrypted = textDecrypted + encryptingMatrix[newRowFirst][newColFirst]
					+ encryptingMatrix[newRowSecond][newColSecond];
		}
//		for (int i = 0; i < encryptingMatrix.length; i++) {
//			for (int j = 0; j < encryptingMatrix.length; j++) {
//				System.out.print(encryptingMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		// System.out.println(textDecrypted);

		return textDecrypted;
	}
}
