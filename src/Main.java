public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro();
        //define os numeros de leitores e escritores
        int numLeitores = 5;
        int numEscritores = 2;

        // Inicia a thread dos leitores
        for (int i = 1; i <= numLeitores; i++) {
            new Thread(new Leitor(livro, i)).start();
        }

        // Inicia a thread dos escritores
        for (int i = 1; i <= numEscritores; i++) {
            new Thread(new Escritor(livro, i)).start();
        }
    }
}
