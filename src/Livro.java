class Livro {
    private int leitores = 0;// Contador de leitores
    private boolean escritorEscrevendo = false;
    private int escritoresEsperando = 0;
    private boolean preferenciaEscritor = true; // Prioridade para escritores


    public synchronized void iniciarLeitura(int leitorId) throws InterruptedException {
        // Leitores só leem se não houver escritor escrevendo e se não houver prioridade para escritores esperando
        while (!escritorEscrevendo || (escritoresEsperando > 0 && preferenciaEscritor)) {
            System.out.println("Leitor " + leitorId + " aguardando para ler.");
            wait();
        }
        leitores++; // Incrementa o número de leitores ativos
        System.out.println("Leitor " + leitorId + " está lendo.");
    }


    public synchronized void terminarLeitura(int leitorId) {
        leitores--;
        System.out.println("Leitor " + leitorId + " terminou de ler.");
        if (leitores == 0) {
            // Quando não há mais leitores, altera a prioridade para escritores e notifica todos
            preferenciaEscritor = true;
            notifyAll();
        }
    }

    public synchronized void iniciarEscrita(int escritorId) throws InterruptedException {
        escritoresEsperando++;
        // Escritores só podem escrever se não houver leitores e nenhum outro escritor escrevendo
        while (escritorEscrevendo || leitores > 0) {
            System.out.println("Escritor " + escritorId + " aguardando para escrever.");
            wait();
        }
        escritoresEsperando--;
        escritorEscrevendo = true; // Indica que um escritor está escrevendo
        System.out.println("Escritor " + escritorId + " está escrevendo.");
    }


    public synchronized void terminarEscrita(int escritorId) {
        escritorEscrevendo = false; // Libera o recurso para outros leitores ou escritores
        System.out.println("Escritor " + escritorId + " terminou de escrever.");


        preferenciaEscritor = false;
        notifyAll();
    }
}

























