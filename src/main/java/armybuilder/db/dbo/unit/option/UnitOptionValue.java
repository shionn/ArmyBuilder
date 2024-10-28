package armybuilder.db.dbo.unit.option;

import armybuilder.db.dbo.option.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitOptionValue {
	private Option option;
	private String value;
}
