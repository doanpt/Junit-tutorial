package mockK

import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.SelectPackages
import org.junit.runner.RunWith


@RunWith(JUnitPlatform::class)
//@SelectClasses(BasicMockKUnitTest::class, HierarchicalMockKUnitTest::class)
@SelectPackages("excercise")
class TestAllSelectPackage {
}