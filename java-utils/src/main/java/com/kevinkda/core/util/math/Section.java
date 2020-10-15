/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.math;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数学区间
 *
 * @author Kevin KDA on 2020/10/14 16:35
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.math
 * @classname Section
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    /**
     * The Left.
     */
    private int left;
    /**
     * The Right.
     */
    private int right;
}