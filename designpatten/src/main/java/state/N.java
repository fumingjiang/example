package state;

/**
 * @author fumj
 * @projectName example
 * @description: TODO
 * @date 2020/9/16 001614:16
 */
public class N implements State {
    @Override
    public void P(Car car) {

    }

    @Override
    public void R(Car car) {
        car.setState(new R());
    }

    @Override
    public void N(Car car) {

    }

    @Override
    public void D(Car car) {
        car.setState(new D());
    }
}
