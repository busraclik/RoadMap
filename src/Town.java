public record Town(String name, double distance) {
    @Override
    public String toString() {
        return name + " " + distance;
    }
}
