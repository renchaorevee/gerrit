// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.httpd;

import org.eclipse.jgit.lib.Config;

public class GerritOptions {
  private final boolean headless;
  private final boolean slave;
  private final boolean polyGerrit;

  public GerritOptions(Config cfg, boolean headless, boolean slave) {
    this.headless = headless;
    this.slave = slave;
    this.polyGerrit = cfg.getBoolean("gerrit", null, "enablePolyGerrit", false);
  }

  public boolean enableDefaultUi() {
    return !headless && !polyGerrit;
  }

  public boolean enableMasterFeatures() {
    return !slave;
  }

  public boolean enablePolyGerrit() {
    return !headless && polyGerrit;
  }
}
