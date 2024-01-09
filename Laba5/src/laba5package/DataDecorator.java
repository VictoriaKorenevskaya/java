package laba5package;

public class DataDecorator implements DataSource {
    private DataSource decor;

    DataDecorator(DataSource source) {
        this.decor = source;
    }

    @Override
    public void writeData(String data) {
        decor.writeData(data);
    }

    @Override
    public String readData() {
        return decor.readData();
    }
}
