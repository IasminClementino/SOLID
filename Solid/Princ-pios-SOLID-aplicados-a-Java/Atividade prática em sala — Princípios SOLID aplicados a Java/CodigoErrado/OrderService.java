import java.util.*;

class OrderService {

    public void processOrder(String customerEmail, List<String> items, String paymentType)
    {
        // cálculo simples
        double total = 0;
        for (String item : items) {
            total += 10.0;
        }

        // pagamento
        if (paymentType.equals("credit")) {
            System.out.println("Pagando com cartão de crédito: " + total);
        } else if (paymentType.equals("pix")) {
            System.out.println("Pagando com PIX: " + total);
        } else if (paymentType.equals("boleto")) {
            System.out.println("Pagando com boleto: " + total);
        }

        // persistência fake
        System.out.println("Salvando pedido no banco");

        // envio de email
        System.out.println("Enviando email para " + customerEmail);
    }
}
/*


 SRP (Single Responsibility): Uma classe deve ter apenas 1 responsabilidade , essa clase possui 4 responsabilidades, essa clase ficou responsavel pelo Calculo
 por processar o metodo de pagamento , salvar o pedido e ainda enviar o email, essas 4 coisas ao mexer com uma delas altera toda a classe


OCP (Open/Closed): Se precisar adcionar um novo metodo de pagamento vai precisar alterar o codigo

LSP (Liskov): O codigo não esta bem estruturado. Não existe: Interface, Herança, Polimorfismo


ISP (Interface Segregation):Não existem interfaces separadas a classe é obrigada a depender de tudo mesmo q so precise de uma coisa.

DIP (Dependency Inversion): classe principal controla os detalhes, em vez de depender de contratos.

Consequências:
- Alto acoplamento
- Baixa coesão
- Baixa extensibilidade
- Dificuldade para testes unitários
*/
