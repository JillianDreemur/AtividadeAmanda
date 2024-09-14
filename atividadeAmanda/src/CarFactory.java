import java.util.HashMap;
import java.util.Map; //importando bibliotecas utilizadas

public class CarFactory {
    private static CarFactory instance; //criando a classe da fabrica e a instancia privada dela
    private Map<String, Integer> contagem; //setando o contador dos carros por modelo

    private CarFactory() { //criando metodo para iniciar o contador
        contagem = new HashMap<>();
    }

    public static synchronized CarFactory getInstance() {
        //criando metodo do padrão Singleton, deixei sincronizado pra que só 1 thread possa usar o metodo de cada vez
        //pra nao ter que ficar criando novas instancias
        if (instance == null) {
            instance = new CarFactory();
            //caso a instancia seja nula, cria uma nova instancia que inicia o codigo da fabrica e retorna a instancia
        }
        return instance;
    }

    public Car novoCarro(String modelo) { //criando o metodo de criação de um novo carro
        contagem.put(modelo, contagem.getOrDefault(modelo, 0) + 1);
        //esse metodo usa a biblioteca Map pra contabilizar o numero de carros vendidos de acordo com cada modelo
        //não conhecia essa bilioteca antes, achei mais prático doq criar um dicionário e somar tudo la no fim
        return new Car(modelo);
    }

    public void relatorio() { //criando o metodo que retorna o relatório das vendas de carro
        System.out.println("Relatório de Vendas:");
        String maisVendido = null; //criando atributo que vai dizer qual foi o modelo mais vendido
        int conta = 0; //criando atributor pra contabilizar a contagem maxima das vendas

        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            //aqui eu criei um loop com o for pra conseguir contabilizar os carros por modelo acessando os dados
            //que eu coloquei no Map; ele vai usar os atributos ali em cima pra guardar a informacao
            //de qual foi o modelo mais vendido e quantos carros desse modelo foram vendidos
            String model = entry.getKey();
            //aqui ele ta usando a entry, que eh a chave de entrada do map pra poder acessar os dados dele com a Key
            int count = entry.getValue();
            //aqui ele ta usando a entry e o Value pra acessar a quantidade de carros vendidos referente
            //ao modelo do carro q esta sendo acessado
            System.out.println("Modelo: " + model + ", Quantidade: " + count);

            if (count > conta) {
                //aqui ele compara se o valor armazenado como o modelo mais vendido eh maior do que o que esta sendo
                //contabilizado no momento
                conta = count;
                maisVendido = model;
                //caso o modelo processado seja maior, ele se torna o novo modelo mais vendido
            }
        }

        if (maisVendido != null) {
            //tambem tem a opção de nenhum carro ter sido vendido; pra não dar erro, deixei um if
            //so pra passsar um textinho caso isso aconteça
            System.out.println("O modelo mais vendido foi o: " + maisVendido + " com " + conta + " unidades vendidas");
            //aqui ele mostra qual foi o modelo mais vendido e quantos desse modelo foram vendidos
        } else {
            System.out.println("Nenhum carro foi vendido");
        }
    }
}
