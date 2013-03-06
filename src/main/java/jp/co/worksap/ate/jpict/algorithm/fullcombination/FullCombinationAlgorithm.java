package jp.co.worksap.ate.jpict.algorithm.fullcombination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import jp.co.worksap.ate.jpict.core.Algorithm;
import jp.co.worksap.ate.jpict.core.Combination;
import jp.co.worksap.ate.jpict.core.CombinationList;
import jp.co.worksap.ate.jpict.core.Parameter;
import jp.co.worksap.ate.jpict.core.ParameterList;
import jp.co.worksap.ate.jpict.core.ParameterValuePair;

public class FullCombinationAlgorithm implements Algorithm {

	@Override
	public CombinationList generate(ParameterList parameters,
			int maxCombinationLimit) {

		Deque<ParameterValuePair> stack = new ArrayDeque<ParameterValuePair>();
		List<Combination> resultList = new ArrayList<Combination>();
		if (maxCombinationLimit != 0) {
			combine(parameters.getParameters(), 0, stack, resultList,
					maxCombinationLimit);
		}

		return new CombinationList(resultList);
	}

	/**
	 * 
	 * @param params
	 * @param fromPosition
	 * @param stack
	 * @param resultList
	 * @param maxCombinationLimit
	 */
	private boolean combine(List<Parameter> params, int fromPosition,
			Deque<ParameterValuePair> stack, List<Combination> resultList,
			int maxCombinationLimit) {

		if (fromPosition >= params.size()) {
			return true;
		}

		Parameter dim = params.get(fromPosition);
		for (String value : dim.getValues()) {
			stack.push(new ParameterValuePair(dim.getId(), dim.getName(), value));
			if (!combine(params, fromPosition + 1, stack, resultList,
					maxCombinationLimit)) {
				return false;
			}
			if (fromPosition == params.size() - 1) {
				resultList.add(new Combination(
						new ArrayList<ParameterValuePair>(stack)));
				if (maxCombinationLimit > 0
						&& resultList.size() >= maxCombinationLimit) {
					return false;
				}
			}
			stack.pop();
		}

		return true;
	}
}