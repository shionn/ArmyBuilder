package armybuilder.db.dbo.option;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitOptionValue {
	private UnitOptionType option;
	private String value;
}
