<h1 align="center">ForumHUB® | ALURA</h1>

<h2 align="center"> 

![200w](https://github.com/user-attachments/assets/06bad340-31eb-44d0-b51c-1e4e6b91359a)

</h2> <br><!--img-gifpig-->

<p align="center">
  <img loading="lazy" 
    src="https://img.shields.io/badge/VERSION-v1.0-purple?style=for-the-badge">
  <img loading="lazy" 
    src="https://img.shields.io/badge/RELEASE%20DATE-JANUARY%20%7C%202025-yellow?style=for-the-badge">
</p>

# ÍNDICE

* [Descrição do Projeto](#descrição-do-projeto)
* [Status do Projeto](#status-do-projeto)
* [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Pessoa Desenvolvedora do Projeto](#pessoa-desenvolvedora-do-projeto)

# DESCRIÇÃO DO PROJETO
 
📄 Este projeto se trata de uma "API REST" criada em JAVA (Spring Boot), que cria um banco de dados local ('Postgres'), gerencia esse banco (com auxílio do framework: 'Hibernate') e faz todo o CRUDD ('Create, Read, Update, Delete and Detail') através de solicitações Web do tipo HTTP.

📄 É válido pontuar que a prioridade desse projeto é arquitetar um CRUDD em uma API REST, mas que seja priorizado um ambiente seguro, protegido de ataques. Para isso, no projeto, foi utilizada a dependência 'Spring Security' alinhada ao uso de 'Tokens tipo JWT'.

📄 Sua idealização foi feita com base no 'Challenge: ForumHUB' da trilha 'Java e Spring Framework G7 - ONE' do programa 'ONE | ALURA'.

🚩 Caso queira testar a aplicação, faz-se necessário popular a tabela 'usuarios' diretamente no banco, com pelo menos um login e senha codificada em hash do tipo BCrypt. Abaixo está um código SQL pronto para popular a respectiva tabela.

<table align="center">
  <thead>
    <tr>
      <th>USUÁRIO</th>
      <th>SENHA</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>admin</td>
      <td>admin99</td>
    </tr>
  </tbody>
</table>

<p align="center">
  INSERT INTO usuarios (id, email, nome, senha) VALUES (1, 'admin.forum@email.com', 'admin', '$2a$12$9u7sd7xwgxp5/CSPuIEYguZC/kciqi14AJudxlmfDAw/AiJbhigNe');
</p>


# STATUS DO PROJETO

<p align="center">
  <img loading="lazy" src="https://img.shields.io/badge/STATUS-FINISHED-green?style=for-the-badge">
</p>

# FUNCIONALIDADES E DEMONSTRAÇÃO DA APLICAÇÃO

https://github.com/user-attachments/assets/28c8f30b-bf69-462b-8df6-dae660a4b6ff

https://github.com/user-attachments/assets/8e1edf42-4c2b-4d31-9b34-f7fb7ce28b20

# TECNOLOGIAS UTILIZADAS

<p align="center">
  <img loading="lazy" 
    src="https://img.shields.io/badge/JAVA-red?style=for-the-badge">
</p>

# PESSOA DESENVOLVEDORA DO PROJETO

<section align="center">
  <img loading="lazy" src="https://github.com/user-attachments/assets/869a58e6-2cf4-46a7-9f26-d98099ee5db6" width="200"/>
  <table align="center">
    <tbody>
      <tr>
        <td colspan="2">🧔 Henrique Luiz Indalencio</td>
      </tr>
      <tr>
        <td>Instagram</td>
        <td>➡️<a href="https://www.instagram.com/henriqueinda/">@henriqueinda</a></td>
      </tr>
      <tr>
        <td>GitHub</td>
        <td>➡️<a href="https://github.com/henriqueinda">@henriqueinda</a></td>
      </tr>
      <tr>
        <td>LinkedIn</td>
        <td>➡️<a href="https://www.linkedin.com/in/henriqueindalencio/">@henriqueindalencio</a></td>
      </tr>
    </tbody>
  </table>
</section>
