# SOLID

Princípios SOLID Aplicados a Java ☕
Este repositório contém uma atividade prática da matéria de Programação IV, desenvolvida para demonstrar a aplicação dos princípios SOLID no desenvolvimento de software com Java. Este projeto ilustra a transição de um código com alto acoplamento para uma arquitetura limpa, coesa e fácil de manter.

🎯 Objetivo da Atividade
Identificar violações de SOLID em um código legado (monolítico).

Refatorar o sistema aplicando os cinco princípios fundamentais: SRP, OCP, LSP, ISP e DIP.

🛠️ O Problema Original (CodigoErrado)
No ficheiro OrderService.java original, a classe possuía múltiplas responsabilidades que violavam os princípios básicos:

Cálculo de preço: Lógica de negócio misturada com processamento.

Pagamento: Uso de estruturas if/else rígidas para diferentes métodos de pagamento.

Persistência: Responsável por salvar dados no banco.

Notificação: Responsável pelo envio de emails.

Consequências: Alto acoplamento, baixa extensibilidade e dificuldade na criação de testes unitários.

🚀 A Solução (Refatoração SOLID)
Abaixo, descreve-se como cada princípio foi aplicado na nova estrutura da pasta src:

1. SRP — Single Responsibility Principle
Cada classe passou a ter uma única responsabilidade:

PriceCalculator: Responsável apenas pelo cálculo do total dos itens.

OrderRepository: Responsável pela persistência dos dados.

EmailNotification: Responsável pela comunicação com o cliente.

OrderService: Atua agora apenas como um orquestrador do fluxo do pedido.

2. OCP — Open/Closed Principle
O sistema foi desenhado para ser aberto para extensão, mas fechado para modificação. Através da interface PaymentProcessor, novos métodos de pagamento podem ser adicionados sem alterar as classes existentes.

3. LSP — Liskov Substitution Principle
As classes CreditCardPayment, PixPayment e BoletoPayment implementam a interface PaymentProcessor e podem ser substituídas entre si sem quebrar a lógica do OrderService.

4. ISP — Interface Segregation Principle
Em vez de uma interface genérica e "gorda", o sistema utiliza interfaces específicas para cada contrato de serviço (como o de pagamento), garantindo que as classes dependam apenas do que realmente utilizam.

5. DIP — Dependency Inversion Principle
A classe principal OrderService agora depende de uma abstração (PaymentProcessor) em vez de implementações concretas dentro do seu método principal, facilitando a troca de comportamentos.

📁 Estrutura do Projeto Refatorado
Plaintext
src/main/java/com/ecommerce/
│
├── calculator/
│   └── PriceCalculator.java   # Lógica de cálculo
├── notification/
│   └── EmailNotification.java  # Lógica de notificações
├── payment/
│   ├── PaymentProcessor.java  # Interface (Abstração)
│   ├── CreditCardPayment.java # Implementação
│   ├── PixPayment.java        # Implementação
│   └── BoletoPayment.java     # Implementação
├── repository/
│   └── OrderRepository.java   # Lógica de banco de dados
└── service/
    └── OrderService.java      # Orquestrador refatorado
💻 Como Executar
Certifique-se de ter o JDK instalado.

Execute a classe Main.java localizada em com.ecommerce.

O sistema processará um pedido de exemplo, demonstrando o cálculo, o pagamento via PIX (ou outro selecionado), a persistência e o envio de email.
