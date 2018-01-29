/*
 * Copyright 2000-2018 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.component.grid.testbench;

import com.vaadin.testbench.TestBenchElement;

public class GridTRElement extends TestBenchElement {

    public GridTHTDElement getCell(GridColumnElement column) {
        TestBenchElement e = (TestBenchElement) executeScript(
                "return Array.from(arguments[0].children)."
                        + "filter(cell => cell._column == arguments[1])[0]",
                this, column);
        return e.wrap(GridTHTDElement.class);
    }

    /**
     * Checks if the row is selected
     *
     * @return <code>true</code> if the row is selected, <code>false</code>
     *         otherwise
     */
    @Override
    public boolean isSelected() {
        return hasAttribute("selected");
    }

    private boolean hasAttribute(String attribute) {
        return (boolean) callFunction("hasAttribute", attribute);
    }

    /**
     * Selects the row if it is not already selected.
     */
    public void select() {
        executeScript("var grid = arguments[0].getRootNode().host;"
                + "grid.selectItem(arguments[0]._item);", this);
    }

    /**
     * Deselects the row if it is selected.
     */
    public void deselect() {
        executeScript("var grid = arguments[0].getRootNode().host;"
                + "grid.deselectItem(arguments[0]._item);", this);
    }
}