import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Ciao Utente, prima di iniziare inserisci il nome ");
        String nome = scanner.nextLine();
        System.out.print(" Inserisci la prima stringa (StrA): ");
        String strA = scanner.nextLine();
        System.out.print(" Inserisci la seconda stringa (StrB): ");
        String strB = scanner.nextLine();


        while (true) {
            System.out.println("  Scegli un'opzione: " + nome);
            System.out.println(" 1. Verifica occorrenze di un carattere in StrB ");
            System.out.println(" 2. Trasforma le stringhe in maiuscole o minuscole ");
            System.out.println(" 3. Verifica se StrA e StrB sono uguali ");
            System.out.println(" 4. Inverti StrA e visualizza la nuova stringa ");
            System.out.println(" 5. Verifica se StrB è contenuta in StrA ");
            System.out.println(" 6. Verifica se StrB è un palindromo ");
            System.out.println(" 7. Esci dal programma ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1 -> {
                    System.out.print( nome + " Inserisci il carattere da verificare: ");
                    char carattere = scanner.nextLine().charAt(0);
                    int occorrenze = occorrenzeInStringa(carattere, strB);
                    System.out.println( nome + " Il carattere '" + carattere + "' è presente " + occorrenze + " volte in StrB. ");
                }
                case 2 -> {
                    strA = capitalizeFirstLetter(strA);
                    strB = capitalizeFirstLetter(strB);
                    System.out.println(" StrA: " + strA);
                    System.out.println(" StrB: " + strB);
                }
                case 3 -> {
                    boolean uguali = strA.equalsIgnoreCase(strB);
                    System.out.println(nome + " StrA e StrB sono " + (uguali ? "" : " non ") + "uguali.");
                }
                case 4 -> {
                    String strAInvertita = invertiStringa(strA);
                    System.out.println( nome + " StrA invertita: " + strAInvertita);
                }
                case 5 -> {
                    boolean contenuta = strA.contains(strB);
                    System.out.println( nome + "StrB " + (contenuta ? " è" : "non è ") + " contenuta in StrA. ");
                }
                case 6 -> {
                    boolean palindromo = isPalindrome(strB);
                    System.out.println( nome + " StrB " + (palindromo ? " è " : "non è ") + " un palindromo. " );
                }
                case 7 -> {
                    System.out.println( " alla prossima " + nome );
                    return;
                }
                default -> System.out.println( nome + " Scelta non valida, riprovare. ");
            }
        }
    }


    private static int occorrenzeInStringa(char carattere, String stringa) {
        int occorrenze = 0;
        for (int i = 0; i < stringa.length(); i++) {
            if (stringa.charAt(i) == carattere) {
                occorrenze++;
            }
        }
        return occorrenze;
    }

    private static String capitalizeFirstLetter(String stringa) {
        return stringa.substring(0, 1).toUpperCase() + stringa.substring(1).toLowerCase();
    }

    private static String invertiStringa(String stringa) {
        StringBuilder stringaInvertita = new StringBuilder();
        for (int i = stringa.length() - 1; i >= 0; i--) {
            stringaInvertita.append(stringa.charAt(i));
        }
        return stringaInvertita.toString();
    }

    private static boolean isPalindrome(String stringa) {
        int lunghezza = stringa.length();
        for (int i = 0; i < lunghezza / 2; i++) {
            if (stringa.charAt(i) != stringa.charAt(lunghezza - i - 1)) {
                return false;
            }
        }
        return true;
    }
}