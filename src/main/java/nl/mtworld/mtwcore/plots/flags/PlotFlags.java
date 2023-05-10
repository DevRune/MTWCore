package nl.mtworld.mtwcore.plots.flags;

public enum PlotFlags {

    SHARDPLOT("shards", "§9WorldShards"),
    STAATSBEDRIJF("staatsbedrijf", "§2Staatsbedrijf"),
    NTK("ntk", "§7Niet Te Koop");

    String name;
    String displayName;
    PlotFlags(String name, String displayName){
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
