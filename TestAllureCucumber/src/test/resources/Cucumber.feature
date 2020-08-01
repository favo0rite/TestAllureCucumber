#language: ru
Функционал: Ипотека
  @all
  @testMortgage
  Сценарий: Проверить условия по ипотеке
    Когда курсор наведен на элемент меню: Ипотека
    Тогда нажимаем на элемент меню: ипотека на готовое жилье и переходим на вкладку ипотечных условий


    Когда Заполнены поля:
      |Стоимость недвижимости|5 180 000|
      |Первоначальный взнос  |3 058 000|
      |Срок кредита          |   30    |
    Тогда Значения полей равны:
      |Ежемесяный взнос|16 922 ₽|
      |Сумма кредита |2 122 000 ₽|
      |Необходимый доход|21 784 ₽|

  @all
  @failure
  Сценарий: проверка поля: процентная ставка
    Когда Заполнены поля:
      |Стоимость недвижимости|5 180 000|
      |Первоначальный взнос  |3 058 000|
      |Срок кредита          |   30    |
    Тогда процентная ставка равна 11%


