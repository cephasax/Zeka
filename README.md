# SOBRE O ZEKA

Escrito em Java, o ZEKA é uma ferramenta de código aberto baseado na API do WEKA. A API inclui uma coleção de algoritmos de aprendizado de máquinas (classificação, regressão , agrupamento , detecção de valores fora da curva) e ferramentas para avaliação.

Atualmente o ZEKA possui os módulos(funcionalidades): 

O primeiro módulo(1) permite o pesquisador escolher um modelo de Aprendizado de Máquina e um ou vários datasets no formato .arff para classificação. 

O segundo módulo(2) realiza a captura da acurácia (porcentagem de acerto) no arquivo .txt resultante dos classificadores presentes no weka. Como resultado, cria-se um  arquivo .txt na raiz do projeto com as todos os valores de acurácia presentes em cada arquivo.

Motivações:

Módulo 1: 
          Testar modelos de ML de forma rápida e sem lidar com codificação. 
          Facilitar o trabalho de aplicação do modelo em mais de um dataset.

Módulo 2
         Facilitar o trabalho de procurar manualmente as acurácias em centenas ou até milhares de arquivos .txt resultantes de classificadores.
         Agilizar o processo de analise de resultados de classificadores.


# Começando com ZEKA
...
# Requisitos para executar ZEKA


1) [Eclipse Oxygen 2018](
https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R2/eclipse-inst-win64.exe&mirror_id=576)


2) [Weka 3.8](http://prdownloads.sourceforge.net/weka/weka-3-8-2jre-x64.exe) 


# Criando um experimento empírico de avaliação

...


 > :AVISO: É necessário que o dataset a ser apresentado ao modelo de classificação(no módulo 1) tenha EXATAMENTE o mesmo formato do dataset que gerou o modelo.
