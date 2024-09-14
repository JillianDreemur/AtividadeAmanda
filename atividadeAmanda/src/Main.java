public class Main {
    public static void main(String[] args) {
        CarFactory factory = CarFactory.getInstance();
        //aqui criei o main e iniciei a fabrica colocando uns carros pra poder fazer os testes
        factory.novoCarro("Fusca");
        factory.novoCarro("Sedan");
        factory.novoCarro("SUV");
        factory.novoCarro("Sedan");
        factory.novoCarro("Fusca");
        factory.novoCarro("Hatchback");
        factory.novoCarro("SUV");
        factory.novoCarro("Fusca");
        factory.novoCarro("SUV");
        factory.novoCarro("Fusca");
        factory.novoCarro("Fusca");

        // Gera e exibe o relatório
        factory.relatorio();
    }
}
