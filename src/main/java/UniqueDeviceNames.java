import java.util.*;

/**
 *  Create unique device names to be used in a residential loT (Internet of Things) system.
 *  If a device name already exists in the system, an integer number is added at the end of the name to make it unique.
 *  integer added starts with 1 and is incremented by 1 for each new request of an existing device name.
 *  Given a list of device name requests, process all requests and return an array of the corresponding
 *  unique device names.
 **/
public class UniqueDeviceNames {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        List<String> solutionList = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        int noOfDevices = input.nextInt();

        for(int count=1; count <= noOfDevices; count++) {
            Scanner nameInput = new Scanner(System.in);
            String name = nameInput.next();
            if(null != name && !name.equals("")) {
                if(null == nameMap.get(name)) {
                    nameMap.put(name, 0);
                } else {
                    nameMap.put(name, nameMap.get(name) + 1);
                }

                if(nameMap.get(name) > 0) {
                    solutionList.add(name + nameMap.get(name));
                } else {
                    solutionList.add(name);
                }
            }
        }
        System.out.println(solutionList);
    }
}
