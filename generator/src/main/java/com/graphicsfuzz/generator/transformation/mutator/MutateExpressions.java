/*
 * Copyright 2018 The GraphicsFuzz Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.graphicsfuzz.generator.transformation.mutator;

import com.graphicsfuzz.common.ast.TranslationUnit;
import com.graphicsfuzz.common.glslversion.ShadingLanguageVersion;
import com.graphicsfuzz.common.typing.Typer;
import com.graphicsfuzz.common.util.IRandom;
import com.graphicsfuzz.generator.transformation.ITransformation;
import com.graphicsfuzz.generator.util.GenerationParams;
import com.graphicsfuzz.generator.util.TransformationProbabilities;
import java.util.List;

public class MutateExpressions implements ITransformation {

  public static final String NAME = "mutate_expressions";

  @Override
  public void apply(TranslationUnit tu, TransformationProbabilities probabilities,
        ShadingLanguageVersion shadingLanguageVersion, IRandom generator,
        GenerationParams generationParams) {
    List<IMutationPoint> mutationPoints = new MutationPoints(new Typer(tu, shadingLanguageVersion),
        tu, shadingLanguageVersion, generator, generationParams).getMutationPoints(probabilities);
    mutationPoints.forEach(IMutationPoint::applyMutation);
  }

  @Override
  public String getName() {
    return NAME;
  }

}
