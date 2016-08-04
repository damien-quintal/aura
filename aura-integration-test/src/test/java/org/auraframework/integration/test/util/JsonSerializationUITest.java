/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.auraframework.integration.test.util;

import org.auraframework.def.ComponentDef;
import org.auraframework.def.DefDescriptor;
import org.auraframework.def.HelperDef;
import org.auraframework.integration.test.util.WebDriverTestCase;
import org.junit.Ignore;
import org.junit.Test;

public class JsonSerializationUITest extends WebDriverTestCase {

    @Ignore("currently fails to parse on client because !-- gets encoded to \u0021-- which is invalid js")
    @Test
    public void testJsOperationBangMinusMinus() throws Exception {
        DefDescriptor<ComponentDef> cmpdd = addSourceAutoCleanup(ComponentDef.class,
                String.format(baseComponentTag, "render='client'", ""));
        addSourceAutoCleanup(
                definitionService.getDefDescriptor(cmpdd, DefDescriptor.JAVASCRIPT_PREFIX, HelperDef.class),
                "({countDown:function(){if(!document.counter)document.counter=3;return !--document.counter?'done':'continue'}})");
        open(cmpdd);
        assertEquals("continue",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().countDown()"));
        assertEquals("continue",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().countDown()"));
        assertEquals("done",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().countDown()"));
    }

    @Test
    public void testJsStringBangMinusMinus() throws Exception {
        DefDescriptor<ComponentDef> cmpdd = addSourceAutoCleanup(ComponentDef.class,
                String.format(baseComponentTag, "render='client'", ""));
        addSourceAutoCleanup(
                definitionService.getDefDescriptor(cmpdd, DefDescriptor.JAVASCRIPT_PREFIX, HelperDef.class),
                "({getComment:function(){return '<!-- inside -->'}})");
        open(cmpdd);
        assertEquals("<!-- inside -->",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().getComment()"));
    }

    @Ignore("fails to match because */ gets encoded to \u002A/")
    @Test
    public void testJsRegexStarSlash() throws Exception {
        DefDescriptor<ComponentDef> cmpdd = addSourceAutoCleanup(ComponentDef.class,
                String.format(baseComponentTag, "render='client'", ""));
        addSourceAutoCleanup(
                definitionService.getDefDescriptor(cmpdd, DefDescriptor.JAVASCRIPT_PREFIX, HelperDef.class),
                "({replaceStar:function(str){return str.replace(/\\*/,'evil')}})");
        open(cmpdd);
        assertEquals("evildoer",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().replaceStar('*doer')"));
    }

    @Test
    public void testJsStringStarSlash() throws Exception {
        DefDescriptor<ComponentDef> cmpdd = addSourceAutoCleanup(ComponentDef.class,
                String.format(baseComponentTag, "render='client'", ""));
        addSourceAutoCleanup(
                definitionService.getDefDescriptor(cmpdd, DefDescriptor.JAVASCRIPT_PREFIX, HelperDef.class),
                "({getComment:function(){return '/* non-comment */'}})");
        open(cmpdd);
        assertEquals("/* non-comment */",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().getComment()"));
    }

    @Ignore("W-2427098: causes JsonStreamParseException because the embedded quotes are read as part of a string rather than literal")
    @Test
    public void testJsLiteralRegexp() throws Exception {
        DefDescriptor<ComponentDef> cmpdd = addSourceAutoCleanup(ComponentDef.class,
                String.format(baseComponentTag, "render='client'", ""));
        addSourceAutoCleanup(
                definitionService.getDefDescriptor(cmpdd, DefDescriptor.JAVASCRIPT_PREFIX, HelperDef.class),
                "({replaceQuotes:function(str){return str.replace(/\"/g,'\\'')}})");
        open(cmpdd);
        assertEquals("'exactly'",getAuraUITestingUtil().getEval("return $A.getRoot().getDef().getHelper().replaceQuotes('\"exactly\"')"));
    }
}
