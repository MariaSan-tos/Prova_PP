class Escritor implements Runnable {
    private Livro livro;
    private int id;

    public Escritor(Livro livro, int id) {
        this.livro = livro;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                livro.iniciarEscrita(id);
                Thread.sleep(1000);
                livro.terminarEscrita(id);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
