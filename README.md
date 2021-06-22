# Systems-Integration-Project-JavaEE-WebServices
 Systems-Integration-Project-JavaEE-WebServices

## Objetivo
O segundo projeto, da unidade curricular de Integração de Sistemas, consiste na implementação de uma aplicação empresarial organizada em camadas utilizando o modelo Java Enterprise Edition (Java EE). Com isso em mente, foi proposto o desenvolvimento de algumas aplicações baseadas em Enterprise JavaBeans, o desenvolvimento de dois web services SOAP e um web service REST, o uso de Persistence Engine e, também, foi proposto o desenvolvimento de um web front-end.

## Enquadramento
O segundo projeto é composto por um conjunto de aplicações independentes que trocam informação entre si, como é possível observar, na arquitetura apresentada, na Figura 1.

O projeto contém uma base de dados que será carregada com informação, relativa a investigadores, publicações e instituições, através de uma aplicação Loader. De forma a visualizar esta informação foram desenvolvidas duas interfaces, uma gráfica que apresenta a informação relativa a todas as publicações que se encontram na base de dados e outra interface em formato consola de texto onde o utilizador pode fazer pedidos para ver as informações relativas aos investigadores, publicações e instituições.

As interfaces solicitam os dados aos web services e estes invocam um Enterprise JavaBean (EJB) que vai à base de dados pesquisar os dados solicitados. Posto isto, o EJB devolve a informação para o web service e, consequente, este devolve-a para o cliente. Desse modo, foram desenvolvidos os seguintes web services e respetivos EJB:
- Um SOAP web service que invoca métodos de um EJB que, por sua vez, vai à base de dados pesquisar informação relativa a investigadores.
- Um SOAP web service que incova métodos de um EJB que, por sua vez, vai à base de dados pesquisar informação relativa a publicações.
- Um REST web service que invoca métodos de um EJB que, por sua vez, vai à base de dados pesquisar informação relativa a instituições.
