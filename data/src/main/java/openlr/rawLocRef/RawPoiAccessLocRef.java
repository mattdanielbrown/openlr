/**
 * Licensed to the TomTom International B.V. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  TomTom International B.V.
 * licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/**
 *  Copyright (C) 2009-2012 TomTom International B.V.
 *
 *   TomTom (Legal Department)
 *   Email: legal@tomtom.com
 *
 *   TomTom (Technical contact)
 *   Email: openlr@tomtom.com
 *
 *   Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 *   the Netherlands
 */
package openlr.rawLocRef;

import openlr.LocationReferencePoint;
import openlr.LocationType;
import openlr.Offsets;
import openlr.location.data.Orientation;
import openlr.location.data.SideOfRoad;
import openlr.map.GeoCoordinates;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Implementation of the RawLocationReference interface for poi with access point locations.
 * 
 * <p>
 * OpenLR is a trade mark of TomTom International B.V.
 * <p>
 * email: software@openlr.org
 * 
 * @author TomTom International B.V.
 */
public class RawPoiAccessLocRef extends RawPointLocRef {

	/** The geo coord. */
	private final GeoCoordinates geoCoord;

	/**
	 * Instantiates a new raw encoder location reference for a poi with
	 * access point location.
	 *
	 * @param idValue the id
	 * @param lrp the lrp
	 * @param lrp2 the lrp2
	 * @param od the od
	 * @param coordinatesData the coordinates data
	 * @param sor the sor
	 * @param o the o
	 */
	public RawPoiAccessLocRef(final String idValue, final LocationReferencePoint lrp,
			final LocationReferencePoint lrp2, final Offsets od,
			final GeoCoordinates coordinatesData, final SideOfRoad sor,
			final Orientation o) {
		super(idValue, LocationType.POI_WITH_ACCESS_POINT, lrp, lrp2, od, sor, o); 
		geoCoord = coordinatesData;
	}
	

	/**
	 * {@inheritDoc}
	 */
	public final GeoCoordinates getGeoCoordinates() {
		return geoCoord;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" locType: ").append(locType);
		if (points != null && !points.isEmpty()) {
			sb.append(" points: ").append(points);
		}
		if (geoCoord != null) {
			sb.append(" geoCoord: ").append(geoCoord);
		}
		if (offsets != null) {
			sb.append(" offsets: ").append(offsets);
		}
		if (orientation != null) {
			sb.append(" orientation: ").append(orientation);
		}
		if (sideOfRoad != null) {
			sb.append(" sideOfRoad: ").append(sideOfRoad);
		}
		return sb.toString();		
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int calculateHashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(locType).append(geoCoord).append(
				sideOfRoad).append(orientation).append(offsets).append(points);
		return builder.toHashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(final Object obj) {
		if (!(obj instanceof RawPoiAccessLocRef)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		RawPoiAccessLocRef other = (RawPoiAccessLocRef) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(locType, other.locType).append(geoCoord, other.geoCoord).append(
				sideOfRoad, other.sideOfRoad).append(orientation,
				other.orientation).append(offsets, other.offsets).append(
				points, other.points);
		return builder.isEquals();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		return getHashCode();
	}
	

}
