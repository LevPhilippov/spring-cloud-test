package lev.filippov;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDto {

    private Long id;

    private String title;

    private Integer price;

}
