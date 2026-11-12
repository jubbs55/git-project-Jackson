import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BranchTester {
    public static void main(String[] args) throws IOException {
        GitWrapper.init();
        Files.writeString(Path.of("blah.txt"), "blah1");
        GitWrapper.add("blah.txt");
        GitWrapper.commit("Jackson", "blah1");
        GitWrapper.createBranch("newbranch");
        GitWrapper.checkout("newbranch");
        Files.writeString(Path.of("blah.txt"), "blah2");
        GitWrapper.add("blah.txt");
        GitWrapper.commit("Jackson", "blah2");
        GitWrapper.checkout("main");
        System.out.println("on main the file is: " + Files.readString(Path.of("blah.txt")));
        GitWrapper.checkout("newbranch");
        System.out.println("on newbranch the file is: " + Files.readString(Path.of("blah.txt")));
    }
}
