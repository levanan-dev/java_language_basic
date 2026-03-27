package mainmethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatabaseBootstrapperTest {
  @Test
  @DisplayName("Trả về thông báo tiến trình khi môi trường là Product")
  void shouldReturnProdMessage_whenEnvIsProd() {
    // AAA pattern
    // Arrange (chuẩn bị dữ liệu)
    DatabaseBootstrapper databaseBootstrapper = new DatabaseBootstrapper();
    String[] env = {"--env=prod"};

    // Act (gọi hàm)
    String actual = databaseBootstrapper.parseEnv(env);

    // Assert (kiểm tra)
    String expected = "Đang kết nối tới PostgreSQL Production...";
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Trả về thông báo tiến trình khi môi trường là Dev")
  void shouldReturnDevMessage_whenEnvIsDev() {
    // AAA pattern
    // Arrange (chuẩn bị dữ liệu)
    DatabaseBootstrapper databaseBootstrapper = new DatabaseBootstrapper();
    String[] env = {"--env=dev"};

    // Act (gọi hàm)
    String actual = databaseBootstrapper.parseEnv(env);

    // Assert (kiểm tra)
    String expected = "Đang khởi tạo H2 Database Local...";
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Trả về thông báo tiến trình khi môi trường là không hợp lệ")
  void shouldReturnInvalidMessage_whenEnvIsUnknow() {
    // AAA pattern
    // Arrange (chuẩn bị dữ liệu)
    DatabaseBootstrapper databaseBootstrapper = new DatabaseBootstrapper();
    String[] env = {"Invalid"};

    // Act (gọi hàm)
    String actual = databaseBootstrapper.parseEnv(env);

    // Assert (kiểm tra)
    String expected = "Môi trường không hợp lệ";
    Assertions.assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Ném ra ngoại lệ khi đầu vào rỗng")
  void shouldThrowIllegalArgumentException_whenArgsIsEmpty() {
    // AAA pattern
    // Arrange (chuẩn bị dữ liệu)
    DatabaseBootstrapper databaseBootstrapper = new DatabaseBootstrapper();
    String[] env = {};

    // Assert (kiểm tra) + Act (gọi hàm)
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          databaseBootstrapper.parseEnv(env);
        });
  }
}
