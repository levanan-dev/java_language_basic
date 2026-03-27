package mainmethod;

public class DatabaseBootstrapper {
  public static void main(String[] args) {
    DatabaseBootstrapper databaseBootstrapper = new DatabaseBootstrapper();

    try {

    } catch (IllegalArgumentException e) {
      System.out.println(
          "Lỗi: Thiếu tham số môi trường. Cách dùng: java DatabaseBootstrapper --env=dev/prod");
      System.exit(1);
    }
    System.out.println(databaseBootstrapper.parseEnv(args));

    System.exit(0);
  }

  public String parseEnv(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("Thiếu tham số...");
    }

    String env = args[0];

    return switch (env) {
      case "--env=prod" -> "Đang kết nối tới PostgreSQL Production...";
      case "--env=dev" -> "Đang khởi tạo H2 Database Local...";
      default -> "Môi trường không hợp lệ";
    };
  }

  // Tư duy test case
  // 1. Convention Testing Naming: Class + Test
  // 2. Function Naming: shouldX_WhenY (Hàm này nên làm gì và trong điều kiện nào)

  // Test Case cho hàm parseEnv
  // 1. shouldReturnProdMessage_whenEnvIsProd
  // 2. shouldReturnDevMessage_whenEnvIsDev
  // 3. shouldReturnInvalidMessage_whenEnvIsUnknow
  // 4. shouldThrowException_whenArgsIsEmpty

}
