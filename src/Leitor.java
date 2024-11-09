class Leitor implements Runnable {
    private Livro livro;
    private int id;

    public Leitor(Livro livro, int id) {
        this.livro = livro;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                livro.iniciarLeitura(id);
                Thread.sleep(1000);
                livro.terminarLeitura(id);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
