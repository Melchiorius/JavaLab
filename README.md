# JavaLab8
*** Наследие ***

Создать базовый абстрактный класс.
Создать два интерфейса, которые являются носителями свойств (по одному свойству каждый).
Реализовать конкретные классы вида: 
1) наследник базового абастрактного класса и реализатор первого интерфейса.
2) наследник базового абастрактного класса и реализатор второго интерфейса.
3) наследник базового абастрактного класса и реализатор и первого и второго интерфейсов.
Затем создать класс Main, в котором создать экземпляры трех классов и продемонстрировать их работу посредством вызова всех их методов.

Реализация:
abstract Class PaneObject: int get/set X, int get/set Y
interface IPaintable: void draw(Graphics g)
interface IMovable: void move(int dX,int dY)

Class Moon extends PaneObject implements IPaintable
Class ViewPoint extends PaneObject implements IMovable
Class Cloud extends PaneObject implements IPaintable, IMovable

Все IPaintable отрисовываются в классе Pane
Все Cloud сдвигаются методом move слева направо каждые 80 млс.
ViewPoint сдвигается влево при нажатии кнопки "влево", и право - при нажатии кнопки "вправо". Отслеживание нажатия кнопок производится в классе Frame. По текущим координатам ViewPoint производится (Graphics g).translate(getX,getY) в классе Pane при общей отрисовке
